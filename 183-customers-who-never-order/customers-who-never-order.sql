# Write your MySQL query statement below
select c.name as Customers from customers c where c.id NOT IN (
    select o.customerId from orders o
);