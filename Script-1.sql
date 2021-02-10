CREATE SEQUENCE car_serial AS integer START 103 OWNED BY cars.car_id;
ALTER TABLE cars ALTER COLUMN car_id SET DEFAULT Nextval('car_serial');

CREATE SEQUENCE login_serial AS integer START 101 OWNED BY login.user_id;
ALTER TABLE login ALTER COLUMN user_id SET DEFAULT nextval('login_serial');

CREATE SEQUENCE account_serial AS integer START 100000000 OWNED BY account.account_number;
ALTER TABLE account ALTER COLUMN account_number SET DEFAULT nextval('account_serial');

CREATE SEQUENCE offers_serial AS integer START 123 OWNED BY offers.offer_id;
ALTER TABLE offers ALTER COLUMN offer_id SET DEFAULT nextval('offers_serial');
