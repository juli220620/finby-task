--liquibase formatted sql
--changeset Julia:create-product-info-table failOnError:true

create table product_info
(
    id                 integer primary key autoincrement,
    name               text not null,
    brand              text not null,
    model              text,
    quantity_available int not null default 1,
    weight             text not null default '0 г',
    rating             real check ( 0. <= product_info.rating and 5. >= product_info.rating ) default 0,
    category           text not null,
    description        text not null,
    colour             text not null,
    price              real not null default 0.00,
    warranty           text not null
);
