--liquibase formatted sql
--changeset M:data-categories

INSERT INTO category (title, text)
VALUES ('Русская кухня', '<p>Традиционная кухня русского народа. Природные особенности мест проживания — обширные леса и долгие зимы — обусловили многие характерные особенности традиционной русской кухни: разнообразие горячих супов и каш, квашений, мочений и солений, грибных блюд и дичи на русском столе. Центральная роль печи в русской избе предопределила важную роль для домашнего хлеба, пирогов, томлёных, тушёных, варёных и печёных блюд.</p>'),
       ('Китайская кухня', '<p>История китайской кухни начинается с неолита, с течением времени в разных регионах появились собственные предпочтения в зависимости от климата и придворной моды. С течением времени в китайскую кухню были интегрированы иностранные ингредиенты и традиции приготовления пищи. Имеются специфические кулинарные особенности, характерные для людей разного социального класса и национальности.</p>'),
       ('Бразильская кухня', '<p>Совокупность кулинарных традиций Бразилии, представляет собой смесь традиций, заимствованных из португальской кухни со множеством элементов самого различного происхождения.</p>');