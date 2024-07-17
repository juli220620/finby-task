--liquibase formatted sql
--changeset Julia:create-product-photo-table failOnError:true

create table product_photo
(
    id         integer primary key autoincrement,
    product_id integer not null,
    data       blob not null,
    name       text not null,
    foreign key (product_id) references product_info (id)
);
