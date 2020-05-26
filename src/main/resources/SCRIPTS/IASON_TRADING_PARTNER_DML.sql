insert into trading_partner (trading_partner_sk, trading_partner_desc, trading_partner_id, state_code, hios, created_date, last_modified_date)
                     values (tp_sequence.nextval, 'Nevada Trading Partner', '204761189', 'NV', '45142', sysdate, sysdate);
insert into transaction_source(transaction_source_sk, transaction_source_name, sender_id, receiver_id, market_place_type, trading_partner_sk, effective_date, end_date, created_date, last_modified_date)
                    values (ts_sequence.nextval, 'Nevada - FFM', 'CMSFFM', '204761189', 'FFM', 10001, TO_DATE('2003/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), null, sysdate, sysdate);
insert into transaction_source(transaction_source_sk, transaction_source_name, sender_id, receiver_id, market_place_type, trading_partner_sk, effective_date, end_date, created_date, last_modified_date)
                    values (ts_sequence.nextval, 'Nevada - SBE', 'NV0', '204761189', 'SBE', 10001, TO_DATE('2003/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), null, sysdate, sysdate);
COMMIT;