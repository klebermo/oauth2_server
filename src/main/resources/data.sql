insert into credencial (nome) values ('basic');
insert into autorizacao (nome) values ('read');
insert into autorizacao (nome) values ('write');

insert into usuario (username, password, first_name, last_name, email, enabled, locked) values ('kleber', '$2y$04$I7gWK8SNW8aLynMW334dPOcfCKjYFLNFZywsr8R0wJzgXjs.mNJ3q', 'Kleber', 'Mota', 'kleber@mail.com', true, false);
insert into usuario_credenciais values (1,1);

insert into oauth_client_details (client_id,client_secret,authorized_grant_types,access_token_validity,refresh_token_validity,web_server_redirect_uri,resource_ids,scope,scoped,secret_required,autoapprove) values ('first-client', '', 'authorizantion_code', 36000, 36000, 'http://localhost:8081', null, 'read', true, true, true);
