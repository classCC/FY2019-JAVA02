package com.wz.service.impl;

import com.google.common.collect.Lists;
import com.wz.common.CheckEnum;
import com.wz.common.ResponseCode;
import com.wz.common.ServerResponse;
import com.wz.dao.CartMapper;
import com.wz.pojo.Cart;
import com.wz.pojo.Product;
import com.wz.service.ICartService;
import com.wz.service.IProductService;
import com.wz.utils.BigDecimalUtils;
import com.wz.vo.CartProductVO;
import com.wz.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    IProductService productService;

    @Autowired
    CartMapper cartMapper;


    @Override
    public ServerResponse addProductToCart(Integer userId, Integer productId, Integer count) {

        //step1:参数非空判断
        if (productId==null){
            return ServerResponse.serverResponseByError(ResponseCode.ERROR,"商品id不能为空");
        }
        if (count==null){
            return ServerResponse.serverResponseByError(ResponseCode.ERROR,"商品数量不能为0");
        }
        //step2:判断商品是否存在

        ServerResponse<Product> serverResponse=productService.findProductById(productId);
        if (!serverResponse.isSuccess()){
            return ServerResponse.serverResponseByError(serverResponse.getStatus(),serverResponse.getMsg());
        }else{
            Product product=serverResponse.getData();
            if (product.getStock()<=0){
                return ServerResponse.serverResponseByError(ResponseCode.ERROR,"商品已售罄");
            }
        }

        //step3:判断商品是否在购物车
        Cart cart=cartMapper.findCartByUseridAndProductId(userId,productId);
        if (cart==null){
            //添加
            Cart newCart=new Cart();
            newCart.setUserId(userId);
            newCart.setProductId(productId);
            newCart.setQuantity(count);
            newCart.setChecked(CheckEnum.CART_PRODUCT_CHECK.getCheck());
            int result=cartMapper.insert(newCart);
            if (result<=0){
                return ServerResponse.serverResponseByError(ResponseCode.ERROR,"添加失败");
            }
        }else{//更新商品在购物车中的数量
            cart.setQuantity(cart.getQuantity()+count);
            int result=cartMapper.updateByPrimaryKey(cart);
            if (result<=0){
                return ServerResponse.serverResponseByError(ResponseCode.ERROR,"更新失败");
            }
        }
        //step4:封装购物车对象CartVO
        CartVO cartVO=getCartVO(userId);

        //step5:返回CartVO
        return ServerResponse.serverResponseBySuccess(cartVO);
    }

    @Override
    public ServerResponse findCartsByUseridAndChecked(Integer userId) {

        List<Cart> cartList=cartMapper.findCartsByUseridAndChecked(userId);

        return ServerResponse.serverResponseBySuccess(cartList);
    }

    @Override
    public ServerResponse deleteBatch(List<Cart> cartList) {

        if (cartList==null||cartList.size()==0) {
            return ServerResponse.serverResponseByError(ResponseCode.ERROR,"要删除的购物车不能为空");
        }
        int result=cartMapper.deleteBatch(cartList);
        if (result!=cartList.size()){
            return ServerResponse.serverResponseByError(ResponseCode.ERROR,"购物车清空失败");
        }

        return ServerResponse.serverResponseBySuccess();
    }

    private CartVO getCartVO(Integer userId){

        CartVO cartVO=new CartVO();
        //step1:根据userID查询该用户的购物车信息
        List<Cart> cartList=cartMapper.findCartByUserid(userId);

        if (cartList==null||cartList.size()==0) {
            return cartVO;
        }

        //定义购物车商品总价格
        BigDecimal cartTotalPrice=new BigDecimal("0");

        //step2:List<Cart> -->List<CartProductVO>
        List<CartProductVO> cartProductVOList= Lists.newArrayList();
        int limit_quantity=0;
        String limitQuantity=null;
        for (Cart cart:cartList){
            CartProductVO cartPtoductVO=new CartProductVO();
            cartPtoductVO.setId(cart.getId());
            cartPtoductVO.setUserId(userId);
            cartPtoductVO.setProductId(cart.getProductId());
            ServerResponse<Product> serverResponse=productService.findProductById(cart.getProductId());
            if (serverResponse.isSuccess()){
                Product product=serverResponse.getData();
                if (product.getStock()>=cart.getQuantity()){
                    limit_quantity=cart.getQuantity();
                    limitQuantity="LIMIT_NUM_SUCCESS";
                }else{
                    limit_quantity=product.getStock();
                    limitQuantity="LIMIT_NUM_FAIL";
                }
                cartPtoductVO.setQuantity(limit_quantity);
                cartPtoductVO.setLimitQuantity(limitQuantity);
                cartPtoductVO.setProductName(product.getName());
                cartPtoductVO.setProductSubtitle(product.getSubtitle());
                cartPtoductVO.setProductMainImage(product.getMainImage());
                cartPtoductVO.setProductPrice(product.getPrice());
                cartPtoductVO.setProductStatus(product.getStatus());
                cartPtoductVO.setProductTotalPrice(BigDecimalUtils.mul(product.getPrice().doubleValue(),
                        cart.getQuantity()*1.0));
                cartPtoductVO.setProductStock(product.getStock());

                cartProductVOList.add(cartPtoductVO);

                if (cart.getChecked()==CheckEnum.CART_PRODUCT_CHECK.getCheck()){
                    //商品被选中
                    cartTotalPrice=BigDecimalUtils.add(cartTotalPrice.doubleValue(),cartPtoductVO.getProductTotalPrice().doubleValue());
                }
            }
        }
        cartVO.setCartProductVOList(cartProductVOList);
        //step3:计算购物车总价
        cartVO.setCartTotalPrice(cartTotalPrice);
        //step4:判断是否全选
        Integer isAllChecked=cartMapper.isAllChecked(userId);
        if (isAllChecked==null){
            cartVO.setAllChecked(true);
        }
        cartVO.setAllChecked(false);
        //step5:构建cartvo

        return cartVO;
    }
}
