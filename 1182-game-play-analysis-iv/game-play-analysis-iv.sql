# Write your MySQL query statement below

-- SELECT ROUND(
--     COUNT(DISTINCT a2.player_id) 
--     / 
--     COUNT(DISTINCT a1.player_id), 
--     2
-- ) AS fraction
-- FROM Activity a1
-- LEFT JOIN Activity a2
-- ON a1.player_id = a2.player_id
-- AND a2.event_date = (
--     SELECT MIN(event_date) 
--     FROM Activity 
--     WHERE player_id = a1.player_id
-- ) + INTERVAL 1 DAY;



WITH first_login AS (
    SELECT player_id, MIN(event_date) AS first_date
    FROM Activity
    GROUP BY player_id
)
SELECT ROUND(
    COUNT(DISTINCT a.player_id) / 
    COUNT(DISTINCT f.player_id),
    2
) AS fraction
FROM first_login f
LEFT JOIN Activity a
    ON f.player_id = a.player_id
    AND a.event_date = f.first_date + INTERVAL 1 DAY;