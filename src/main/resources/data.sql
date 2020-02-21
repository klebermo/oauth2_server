insert into autorizacao (id, name) values (1, 'read');
insert into autorizacao (id, name) values (2, 'write');

insert into usuario (id, username, password) values (1, 'kleber', '');
insert into usuario_autorizacoes values (1,1);
insert into usuario_autorizacoes values (1,2);

insert into cliente (client_id, client_secret, authorized_grant_types, access_token_validity_seconds, refresh_token_validity_seconds, redirect_uris, resource_id, scope, auto_approve, scoped, secret_required) values ('first-client', 'noonewilleverguess', 'authorization_code', 3600, 3600, 'http://localhost:8081/', '', 'read', true, true, true);
insert into cliente_autorizacoes values (1,1);
insert into cliente_autorizacoes values (1,2);
