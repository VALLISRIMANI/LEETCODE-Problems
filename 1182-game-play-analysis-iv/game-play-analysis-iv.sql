# Write your MySQL query statement below

SELECT ROUND(
    COUNT(DISTINCT a2.player_id) 
    / 
    COUNT(DISTINCT a1.player_id), 
    2
) AS fraction
FROM Activity a1
LEFT JOIN Activity a2
ON a1.player_id = a2.player_id
AND a2.event_date = (
    SELECT MIN(event_date) 
    FROM Activity 
    WHERE player_id = a1.player_id
) + INTERVAL 1 DAY;