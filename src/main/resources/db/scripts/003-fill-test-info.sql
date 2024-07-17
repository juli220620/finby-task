--liquibase formatted sql
--changeset Julia:fill-test-info failOnError:true

insert into product_info(id, name, brand, model, category, description, colour, warranty, rating, price)
VALUES (1, 'A', 'AA', 'AAA', 'AAAA', 'A AA, AAA, AAAA', 'AAA', 'AAAAAAA', 2.0, 100.0),
       (2, 'B', 'BB', 'BBB', 'BBBB', 'B BB, BBB, BBBB', 'BBB', 'BBBBBBB', 4.0, 200.0);

insert into product_feature (product_id, feature)
VALUES (1, 'AAAA'),
       (2, 'BBBB');