
select * from (
  select *, row_number() over(order by t1.字段 asc) as rownumber from 表名 as t1
  where  条件
) as t2
where rownumber between  (当前页数-1)*每页记录数+1 and 当前页数 * 每页记录数



-- 动态条件查询 + 分页查询
select * from (
  select *, row_number() over(order by t1.product_id asc) as rownumber from product as t1
  where 1=1 and product_name like '%7%' and product_type='玩具'
) as t2
where rownumber between  1 and 5