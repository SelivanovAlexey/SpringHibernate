CREATE SEQUENCE public.book_id_seq;

ALTER SEQUENCE public.book_id_seq
    OWNER TO postgres;
	
CREATE SEQUENCE public.customer_id_seq;

ALTER SEQUENCE public.customer_id_seq
    OWNER TO postgres;
	
CREATE SEQUENCE public.store_id_seq;

ALTER SEQUENCE public.store_id_seq
    OWNER TO postgres;
	
CREATE SEQUENCE public.purchase_order_id_seq;

ALTER SEQUENCE public.purchase_order_id_seq
    OWNER TO postgres;
	

CREATE TABLE public.book
(
    id integer NOT NULL DEFAULT nextval('book_id_seq'::regclass),
    book_name text COLLATE "default" NOT NULL,
    cost numeric NOT NULL,
    storage text COLLATE "default" NOT NULL,
    qty numeric NOT NULL,
    CONSTRAINT book_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.book
    OWNER to postgres;
COMMENT ON TABLE public.book
    IS 'Table contains information about books in stock';
	
CREATE TABLE public.customer
(
    id integer NOT NULL DEFAULT nextval('customer_id_seq'::regclass),
    last_name text COLLATE pg_catalog."default" NOT NULL,
    district text COLLATE pg_catalog."default" NOT NULL,
    discount numeric NOT NULL,
    CONSTRAINT customer_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.customer
    OWNER to postgres;
COMMENT ON TABLE public.customer
    IS 'Table contains information about customers';
	
CREATE TABLE public.store
(
    id integer NOT NULL DEFAULT nextval('store_id_seq'::regclass),
    store_name text COLLATE pg_catalog."default" NOT NULL,
    district text COLLATE pg_catalog."default" NOT NULL,
    commission numeric NOT NULL,
    CONSTRAINT store_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.store
    OWNER to postgres;
COMMENT ON TABLE public.store
    IS 'Information about shops in current city';
	
CREATE TABLE public.purchase
(
    order_id integer NOT NULL DEFAULT nextval('purchase_order_id_seq'::regclass),
    date date NOT NULL,
    vendor_id integer NOT NULL,
    customer_id integer NOT NULL,
    book_id integer NOT NULL,
    book_qty integer NOT NULL,
    amount integer NOT NULL,
    CONSTRAINT purchase_pkey PRIMARY KEY (order_id),
    CONSTRAINT book_fkey FOREIGN KEY (book_id)
        REFERENCES public.book (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT customer_fkey FOREIGN KEY (customer_id)
        REFERENCES public.customer (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT vendor_fkey FOREIGN KEY (vendor_id)
        REFERENCES public.store (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.purchase
    OWNER to postgres;
COMMENT ON TABLE public.purchase
    IS 'Information about all purchases';

-- Index: fki_book_fkey

-- DROP INDEX public.fki_book_fkey;

CREATE INDEX fki_book_fkey
    ON public.purchase USING btree
    (book_id)
    TABLESPACE pg_default;

-- Index: fki_customer_fkey

-- DROP INDEX public.fki_customer_fkey;

CREATE INDEX fki_customer_fkey
    ON public.purchase USING btree
    (customer_id)
    TABLESPACE pg_default;

-- Index: fki_vendor_fkey

-- DROP INDEX public.fki_vendor_fkey;

CREATE INDEX fki_vendor_fkey
    ON public.purchase USING btree
    (vendor_id)
    TABLESPACE pg_default;
	
	
	
INSERT INTO public.book(
	id, book_name, cost, storage, qty)
	VALUES (1, 'War and Peace', 1499,'Sormovo',15);
	
INSERT INTO public.book(
	id, book_name, cost, storage, qty)
	VALUES (2,'We',2499,'Avtozavod',10);
	
INSERT INTO public.book(
	id, book_name, cost, storage, qty)
	VALUES (3,'Windows for beginners',25999,'Avtozavod',1);
	

	
	
	
INSERT INTO public.customer(
	id, last_name, district, discount)
	VALUES (1, 'Sidorov', 'Nizhegorodsky', 30);
	
INSERT INTO public.customer(
	id, last_name, district, discount)
	VALUES (2, 'Smirnov', 'Nizhegorodsky', 15);
	
INSERT INTO public.customer(
	id, last_name, district, discount)
	VALUES (3, 'Petrov', 'Sormovo', 20);
	
INSERT INTO public.customer(
	id, last_name, district, discount)
	VALUES (4, 'Ivanov', 'Kanavino', 18);

	
	
	
	
INSERT INTO public.store(
	id, store_name, district, commission)
	VALUES (1,'Labirint','Sovietsky',10);

INSERT INTO public.store(
	id, store_name, district, commission)
	VALUES (2,'Chitai-gorod','Avtozavod',15);

INSERT INTO public.store(
	id, store_name, district, commission)
	VALUES (3,'House of book','Kanavino',20);

INSERT INTO public.store(
	id, store_name, district, commission)
	VALUES (4,'Dirizhabl','Sormovo',17);


	
	
	
	
INSERT INTO public.purchase(
	order_id, date, vendor_id, customer_id, book_id, book_qty, amount)
	VALUES (1,'2019-01-09',1,3,1,3,3000);	
	
INSERT INTO public.purchase(
	order_id, date, vendor_id, customer_id, book_id, book_qty, amount)
	VALUES (2,'2019-01-09',2,2,1,32,10000);
	
INSERT INTO public.purchase(
	order_id, date, vendor_id, customer_id, book_id, book_qty, amount)
	VALUES (3,'2019-01-09',3,4,2,12,15000);
	