# Write your MySQL query statement below
WITH data AS (
    SELECT player_id, event_date,
    DENSE_RANK() OVER (
        PARTITION BY player_id
        ORDER BY event_date
    ) AS rnk
    FROM activity 
) 
SELECT player_id, event_date AS first_login FROM data WHERE rnk = 1;