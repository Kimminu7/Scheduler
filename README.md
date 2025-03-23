# Scheduler

## Lv 0. API 명세 및 ERD 작성

### ※ 일정 관리 API 명세서

<a href="https://workable-hacksaw-44c.notion.site/1becef54a35680bc87b3d382bc9df4b1?v=1becef54a35680c694ef000c57e5bd3b">보러가기</a>

### ※ ERD

![img_2.png](img_2.png)

- [ ] ERD CLOUD 사이트 에서 구성함.

### ※ SQL 작성

```sql
CREATE TABLE `user` (
    `id`  INT NOT NULL,
    `name` VARCHAR(20) NULL,
    `contents` VARCHAR(255) NULL,
    `password` INT NULL,
    `created_at` DATE NULL,
    `updated_at` DATE NULL
);
```