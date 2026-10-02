# Write your MySQL query statement below

WITH ranked_orders AS (
    SELECT customer_number, 
        COUNT(customer_number),
        DENSE_RANK() OVER (
            ORDER BY COUNT(customer_number) DESC
        ) AS rnk
    FROM Orders
    GROUP BY customer_number
)
SELECT customer_number FROM ranked_orders WHERE rnk = 1;