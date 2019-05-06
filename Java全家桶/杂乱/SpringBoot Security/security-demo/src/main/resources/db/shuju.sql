insert into sys_user (id,username, password) values (1,'vini', '123');
insert into sys_user (id,username, password) values (2,'bronk', '123');

insert into sys_role(id,name) values(1,'ROLE_ADMIN');
insert into sys_role(id,name) values(2,'ROLE_USER');

insert into sys_role_user(sys_user_id,sys_role_id) values(1,1);
insert into sys_role_user(sys_user_id,sys_role_id) values(2,2);

BEGIN;
INSERT INTO `sys_permission` VALUES ('1', 'ROLE_HOME', 'home', '/', null),
  ('2', 'ROLE_ADMIN', 'ABel', '/admin', null);
COMMIT;

BEGIN;
INSERT INTO `sys_permission_role` VALUES ('1', '1', '1'), ('2', '1', '2'), ('3', '2', '1');
COMMIT;