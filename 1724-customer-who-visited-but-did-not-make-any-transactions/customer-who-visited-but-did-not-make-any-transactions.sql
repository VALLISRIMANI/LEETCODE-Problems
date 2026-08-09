# Write your MySQL query statement below
select v.customer_id as customer_id, count(customer_id) as count_no_trans
from visits v
where v.visit_id not in (
    select visit_id from Transactions
)
group by v.customer_id; 
