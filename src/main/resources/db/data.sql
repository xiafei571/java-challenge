INSERT INTO `EMPLOYEE` (`DEPARTMENT`, `EMPLOYEE_NAME`, `EMPLOYEE_SALARY`) values('Engineering', 'Tom', 5001);
INSERT INTO `EMPLOYEE` (`DEPARTMENT`, `EMPLOYEE_NAME`, `EMPLOYEE_SALARY`) values('Testing', 'Jerry', 4001);

INSERT INTO `USER` (`USER_NAME`, `USER_PASSWORD`, `ACTIVE`, `ROLES`, `PERMISSIONS`) values('admin', '$2a$10$W4nuIC5iE8u7h8BN02.B9uvckyoKtZ8/htr9vEV6Tio7dYkXuaf7G', 1, 'ADMIN', 'ACCESS_ADMIN1,ACCESS_ADMIN2');
INSERT INTO `USER` (`USER_NAME`, `USER_PASSWORD`, `ACTIVE`, `ROLES`, `PERMISSIONS`) values('user', '$2a$10$fykyiXvMSRZjsutrCtzL3OeqAWa68V1XuCf2uJXDvX4dDkRcqzDiK', 1, 'USER', 'ACCESS_USER1,ACCESS_USER2');