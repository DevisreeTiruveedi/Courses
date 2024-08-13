CREATE TABLE IF NOT EXISTS `course` (
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(20) NOT NULL,
    description VARCHAR(200) DEFAULT NULL,
    category VARCHAR(30) NOT NULL,
    duration VARCHAR(30) NOT NULL,
    creator_id VARCHAR(30) NOT NULL
);
CREATE TABLE IF NOT EXISTS `assign` (
    course_id INT AUTO_INCREMENT,
    user_id VARCHAR(30) NOT NULL

);