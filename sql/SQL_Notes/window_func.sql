--  creating window in table
-- over() partition by
-- rank() dense_rank()
-- lead() lag()

--------------

-- first_value() , last_value() , using frame clause in them
-- creating alias for window function
-- nth_value(), ntile()
-- cume_dist(), percent_rank()


show databases;
use employees;
show tables;
select * from employee;

with e as
(
select emp_id,emp_name,dept_name
from employee
where salary < 6000
)
,emp as
(
select emp_id,salary
from employee
where salary > 4000
)
select * from e
inner join emp on
e.emp_id = emp.emp_id
where e.emp_id between 100 and 120 
order by e.emp_id;
-- over() to create window

select e.* from(
select *,row_number() over(partition by dept_name order by salary desc) as salary_rank
from employee
) as e
where salary_rank< 3;

select e.* from(
select *,rank() over(partition by dept_name order by salary desc) as salary_rank
from employee
) as e
where salary_rank< 3;

select * ,
row_number() over(partition by dept_name order by salary desc) as rw_number,
rank() over(partition by dept_name order by salary desc) as rnk,
dense_rank() over(partition by dept_name order by salary desc) as dense_rnk
from employee;

select *,
lag(salary) over(partition by dept_name) as prev_emp_sal,
lead(salary) over(partition by dept_name) as next_emp_sal
from employee;

select e.*,
lag(salary) over(partition by dept_name) as prev_emp_sal,
lead(salary) over(partition by dept_name) as next_emp_sal,
case
	when salary > lag(salary) over(partition by dept_name) then 'higher'
    when salary = lag(salary) over(partition by dept_name) then 'equal'
    when salary < lag(salary) over(partition by dept_name) then 'lower'
	end as salary_diff
from employee e;


-- --------------------------------------------------

show databases;
use employees;
show tables;
select * from product;

select *,
first_value(product_name) over w as frst_val,
last_value(product_name) over w as lst_val,
nth_value(product_name,2) over w as second_val
from product
where product_category = 'Phone'
window w as (partition by product_category order by price desc
rows between unbounded preceding and unbounded following);


select product_category, product_name,
case when cost_rank = 1 then 'Expensive'
	when cost_rank = 2 then 'Mid range'
    when cost_rank = 3 then 'cheap'
end as cost
from(
select *,
ntile(3) over(partition by product_category order by price desc) as cost_rank
from product) x;

select *,
round(cume_dist() over(order by price)*100,2) as cume_distrib,
round(percent_rank() over(order by price)*100,2) as perc_distrib
from product;

