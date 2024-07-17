--liquibase formatted sql
--changeset Julia:create-product-feature-table failOnError:true

create table product_feature
(
    product_id int  not null,
    feature    text not null,
    primary key (product_id, feature),
    foreign key (product_id) references product_info (id)
);