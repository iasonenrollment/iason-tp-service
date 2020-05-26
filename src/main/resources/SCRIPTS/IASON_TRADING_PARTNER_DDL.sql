create sequence tp_sequence start with 10001 increment by 1;

create sequence ts_sequence start with 20001 increment by 1;

create table trading_partner (trading_partner_sk NUMBER not null, 
                              created_date timestamp, 
                              hios varchar(255), 
                              last_modified_date timestamp, 
                              state_code varchar(255), 
                              trading_partner_desc varchar(255) not null, 
                              trading_partner_id varchar(255) not null, 
                              primary key (trading_partner_sk));

create table transaction_source (transaction_source_sk NUMBER not null, 
                                 created_date timestamp, 
                                 effective_date timestamp not null, 
                                 end_date timestamp, 
                                 last_modified_date timestamp, 
                                 market_place_type varchar(255) not null, 
                                 receiver_id varchar(255) not null, 
                                 sender_id varchar(255) not null, 
                                 transaction_source_name varchar(255) not null, 
                                 trading_partner_sk NUMBER not null, 
                                 primary key (transaction_source_sk));

alter table trading_partner add constraint UK_41skklvtfyevpsyod6741qhus unique (trading_partner_desc);

alter table trading_partner add constraint UK_dbkqssksrnkrnl3v1ufr5wh19 unique (trading_partner_id);

alter table transaction_source add constraint FKqcbk15ig99khdje6ree1qc8sg foreign key (trading_partner_sk) references trading_partner;