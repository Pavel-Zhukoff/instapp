create table account (
    account_id  bigserial not null,
    email varchar(255) not null,
    password varchar(255) not null,
    register_date timestamp not null,
    role varchar(255) not null,
    primary key (account_id)
);
create table media (
    media_id  bigserial not null,
    creation_date timestamp not null,
    media_type varchar(255) not null,
    name varchar(255) not null,
    post_id int8,
    primary key (media_id)
);
create table post (
    post_id  bigserial not null,
    capiton TEXT,
    creation_date timestamp not null,
    publication_date timestamp not null,
    iaccount_id int8,
    primary key (post_id)
);
create table instagram_account (
    iaccount_id  bigserial not null,
    name varchar(255) not null,
    token varchar(255) not null,
    token_creation_date timestamp,
    account_id int8,
    primary key (iaccount_id)
);
alter table account
    add constraint UK_email_account unique (email);
alter table account
    add constraint UK_password_account unique (password);
alter table instagram_account
    add constraint UK_name_instagram_account unique (name);
alter table media
    add constraint UK_name_media unique (name);
alter table instagram_account
    add constraint FK_instagram_account_account foreign key (account_id) references account;
alter table media
    add constraint FK_media_post foreign key (post_id) references post;
alter table post
    add constraint FK_post_instagram_account foreign key (iaccount_id) references instagram_account;