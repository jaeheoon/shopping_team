/* #1. HR ���Դ� ����� ���� ������ ���� ������ DBA ����(sys or system)���� ���� �� User ���� */
-- sqlplus ���� : conn /as sysdba;
SELECT *
FROM hr.employees;
        
/* #2. User ���� - �����⸸ ������� */
CREATE USER team IDENTIFIED BY team;

commit;

/* #3. ������ User�� �ý��� ���� / ��ü(���̺�, �� ��)�� ���� ���� �ο� */

-- �ý��� ���� ���� �ο� - �α��� �� �� �ְԲ� ���� �ο�
GRANT CREATE SESSION TO team;
-- ��ü�� ���� ���� �ο�(sys�� bangry���� hr��Ű���� employees ���̺� ���� CRUD ������ �ο�)
GRANT SELECT, INSERT, UPDATE, DELETE ON hr.employees TO team;

/* #4. �ʿ信 ���� User���� �ο��� ���� ȸ�� */
REVOKE SELECT, INSERT, UPDATE, DELETE ON hr.employees
FROM team;

/* ��(ROLE) : ���� ���ѵ��� ����(���� �� / ����� ���� ��) */--------------------------------
/* #1. User�� ���� �� �ο� */
GRANT CONNECT, RESOURCE, DBA TO team;

/* #2. ����� ���� �� ���� */
CREATE ROLE some_role;
--DROP ROLE some_role;

/* #3. �ý��� ���Ѱ� ��ü ������ �ѿ� ��� */
GRANT CREATE SESSION TO some_role;
GRANT SELECT, INSERT, UPDATE, DELETE ON hr.employees TO some_role;

-- �� ��� ������ �ѿ� �ο�
GRANT ALL ON hr.employees TO some_role;

/* #4. User�� ����� ���� �� �ο� */
GRANT some_role TO team;

/* #5. User ��� �� ���� */
ALTER USER team ACCOUNT LOCK;
ALTER USER team ACCOUNT UNLOCK;

/* #6. User ��й�ȣ ���� */
--ALTER USER bangry IDENTIFIED BY bbangry;
--ALTER USER hr IDENTIFIED BY hr ACCOUNT UNLOCK;

/* #7. User ���� */
DROP USER team CASCADE;

/* #8. ������ ��ųʸ��κ��� ���� ��� ��ȸ */
SELECT * FROM dba_users;

/* #9. ����ڿ��� �ο��� �ý��� ���� ��ȸ */
SELECT *
FROM dba_sys_privs
WHERE grantee = 'team';

/* #10. �ѿ� �ο��� �ý��� ���� ��ȸ */
SELECT *
FROM dba_sys_privs
WHERE grantee = 'SOME_ROLE';

/* #11. ����ڿ��� �ο��� �� ��ȸ */
SELECT *
FROM dba_role_privs
WHERE grantee = 'team';

/* #12. ����ڿ��� �ο��� ��ü ���� ��ȸ */
SELECT *
FROM dba_tab_privs
WHERE grantee = 'team';

