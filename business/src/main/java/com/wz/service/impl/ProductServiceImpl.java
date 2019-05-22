package com.wz.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.wz.common.ResponseCode;
import com.wz.common.ServerResponse;
import com.wz.dao.ProductMapper;
import com.wz.pojo.Category;
import com.wz.pojo.Product;
import com.wz.service.ICategoryService;
import com.wz.service.IProductService;
import com.wz.utils.DateUtils;
import com.wz.vo.ProductDetailVO;
import com.wz.vo.ProductListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    ICategoryService categoryService;

    @Autowired
    ProductMapper ProductMapper;

    @Value("${business.imageHost}")
    private String imageHost;

    @Override
    public ServerResponse addOrUpdate(Product product) {

        if (product==null){
            return ServerResponse.serverResponseByError(ResponseCode.ERROR,"参数必传");
        }

        //subimages 1.png,2.png,3.png
        //step2：设置商品主图 sub_images-->1.jpg,2.jpg,3.jpg
        String subImages=product.getSubImages();
        if (subImages!=null&&!subImages.equals("")){
            String[] subImageArr=subImages.split(",");
            if (subImageArr.length>0){
                product.setMainImage(subImageArr[0]);
            }
        }

        Integer productId=product.getId();
        if (productId==null){
            //添加
            int result=ProductMapper.insert(product);
            if (result<=0) {
                return ServerResponse.serverResponseByError(ResponseCode.ERROR, "添加失败");
            } else{
                return ServerResponse.serverResponseBySuccess();
            }
        }else{
            //更新
            int result=ProductMapper.insert(product);
            if (result<=0) {
                return ServerResponse.serverResponseByError(ResponseCode.ERROR, "更新失败");
            } else{
                return ServerResponse.serverResponseBySuccess();
            }
        }

    }

    @Override
    public ServerResponse search(String productName, Integer productId, Integer pageNum, Integer pageSize) {

        if (productName!=null){
            productName="%"+productName+"%";
        }
        Page page=PageHelper.startPage(pageNum,pageSize);
        List<Product> productList=ProductMapper.findProductsByNameAndId(productId,productName);

        List<ProductListVO> productListVOList= Lists.newArrayList();

        if (productList!=null&&productList.size()>0){
            for (Product product:productList){
                ProductListVO productListVO=assembleProductListVO(product);
                productListVOList.add(productListVO);
            }
        }
        PageInfo pageInfo=new PageInfo(page);


        return ServerResponse.serverResponseBySuccess(pageInfo);
    }

    @Override
    public ServerResponse<ProductDetailVO> detail(Integer productId) {

        Product product=ProductMapper.selectByPrimaryKey(productId);

        if (productId==null){
            return ServerResponse.serverResponseByError(ResponseCode.ERROR,"参数必传");
        }

        ProductDetailVO productDetailVO=assembleProductDetailVO(product);

        return ServerResponse.serverResponseBySuccess(productDetailVO);
    }

    @Override
    public ServerResponse<Product> findProductByProductId(Integer productId) {

        Product product=ProductMapper.selectByPrimaryKey(productId);

        if (productId==null){
            return ServerResponse.serverResponseByError(ResponseCode.ERROR,"参数必传");
        }



        return ServerResponse.serverResponseBySuccess(product);
    }

    @Override
    public ServerResponse<Product> findProductById(Integer productId) {

        if (productId==null){
            return ServerResponse.serverResponseByError(ResponseCode.ERROR,"商品id必传");
        }
        Product product=ProductMapper.selectByPrimaryKey(productId);

        if (product==null){
            return ServerResponse.serverResponseByError(ResponseCode.ERROR,"商品不存在");
        }

        return ServerResponse.serverResponseBySuccess(product);
    }

    @Override
    public ServerResponse reduceSotck(Integer productId, Integer stock) {

        if (productId==null){
            return ServerResponse.serverResponseByError(ResponseCode.ERROR,"商品id必传");
        }

        if (stock==null){
            return ServerResponse.serverResponseByError(ResponseCode.ERROR,"库存参数必传");
        }
        int result=ProductMapper.reduceProductStock(productId, stock);
        if (result<=0){
            return ServerResponse.serverResponseByError(ResponseCode.ERROR,"扣库存失败");
        }
        return ServerResponse.serverResponseBySuccess();
    }


    /**
     * Product-->ProductListVO
     * */
    private  ProductListVO assembleProductListVO(Product product){

        ProductListVO productListVO=new ProductListVO();
        productListVO.setCategoryId(product.getCategoryId());
        productListVO.setId(product.getId());
        productListVO.setMainImage(product.getMainImage());
        productListVO.setName(product.getName());
        productListVO.setPrice(product.getPrice());
        productListVO.setStatus(product.getStatus());
        productListVO.setSubtitle(product.getSubtitle());
        return productListVO;
    }


    private ProductDetailVO assembleProductDetailVO(Product product){

            ProductDetailVO productDetailVO=new ProductDetailVO();
            productDetailVO.setCategoryId(product.getCategoryId());
            productDetailVO.setCreateTime(DateUtils.dateToStr(product.getCreateTime()));
            productDetailVO.setDetail(product.getDetail());
            productDetailVO.setImageHost(imageHost);
            productDetailVO.setName(product.getName());
            productDetailVO.setMainImage(product.getMainImage());
            productDetailVO.setId(product.getId());
            productDetailVO.setPrice(product.getPrice());
            productDetailVO.setStock(product.getStock());
            productDetailVO.setStatus(product.getStatus());
            productDetailVO.setSubImages(product.getSubImages());
            productDetailVO.setSubtitle(product.getSubtitle());
            productDetailVO.setUpdateTime(DateUtils.dateToStr(product.getUpdateTime()));

            //Category category=categoryMapper.selectByPrimaryKey(product.getCategoryId());

            ServerResponse<Category> serverResponse=categoryService.selectCategory(product.getCategoryId());
            Category category=serverResponse.getData();
            if(category!=null){
                productDetailVO.setParentCategoryId(category.getParentId());
            }

        return productDetailVO;

    }

}
