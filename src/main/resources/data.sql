insert into autorizacao (id, name) values (1, 'read');
insert into autorizacao (id, name) values (2, 'write');

insert into usuario (id, username, password) values (1, 'kleber', '');
insert into usuario_autorizacoes values (1,1);
insert into usuario_autorizacoes values (1,2);

insert into cliente (id, client_id, client_secret, access_token_validity_seconds, refresh_token_validity_seconds, auto_approve, scoped, secret_required) values (1, 'first-client', 'noonewilleverguess', 3600, 3600, true, true, true);
insert into cliente_authorized_grant_types values (1, 'authorization_code');
insert into cliente_redirect_uris values (1, 'http://localhost:8081');
insert into cliente_scope values (1, 'read');
