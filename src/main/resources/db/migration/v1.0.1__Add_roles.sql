create table account_role (
    account_id int8 not null,
    roles varchar(255)
);
alter table account_role
    add constraint FK_account_role
        foreign key (account_id) references account;