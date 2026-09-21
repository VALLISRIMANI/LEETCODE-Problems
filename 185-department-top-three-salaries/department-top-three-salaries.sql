# Write your MySQL query statement below
WITH highest_salaries AS (
    SELECT departmentId, name, salary, 
        DENSE_RANK() OVER(
            PARTITION BY departmentId
            ORDER BY salary DESC
        ) AS rnk
    FROM employee
), employees_data AS (
    SELECT d.name AS Department, e.name AS Employee, e.salary AS Salary
    FROM department d
    JOIN highest_salaries e 
    ON d.id = e.departmentId
    WHERE e.rnk <= 3
)
SELECT Department, Employee, Salary FROM employees_data;