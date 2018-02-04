select product.marker,((count(*)-count(distinct TYPE))+1 ) as a1 from product where product.type='pc'  group by product.marker having a1>=3;
