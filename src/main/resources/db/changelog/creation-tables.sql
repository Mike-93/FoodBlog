--liquibase formatted sql
--changeset M:create-all-tables

CREATE TABLE IF NOT EXISTS category
(
    id         SERIAL  NOT NULL,
    title      TEXT    NOT NULL,
    text       TEXT    NOT NULL,
    image      TEXT,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS post
(
    id         SERIAL  NOT NULL,
    title      TEXT    NOT NULL,
    text       TEXT    NOT NULL,
    category_id   INT    NOT NULL,
    image      TEXT,
    PRIMARY KEY (id),
    FOREIGN KEY (category_id) REFERENCES category (id) ON DELETE CASCADE
);