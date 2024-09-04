CREATE TABLE public.master_phone (
	id bigserial NOT NULL,
	phone_owner varchar(255) null,
	phone_type varchar(255) null,
	phone_number varchar(20) NULL,
	provider varchar(255) NULL,
	is_status boolean NULL,
	is_deleted boolean null,
	CONSTRAINT master_phone_pkey PRIMARY KEY (id)
);