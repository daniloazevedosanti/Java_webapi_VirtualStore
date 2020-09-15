--
-- PostgreSQL database dump
--

--
-- Name: table_client; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.table_client (
    id bigint NOT NULL,
    name character varying(255)
);


--
-- Name: table_client_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.table_client_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: table_client_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.table_client_id_seq OWNED BY public.table_client.id;


--
-- Name: table_order; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.table_order (
    id bigint NOT NULL,
    moment timestamp without time zone,
    client_id bigint
);


--
-- Name: table_order_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.table_order_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: table_order_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.table_order_id_seq OWNED BY public.table_order.id;


--
-- Name: table_order_item; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.table_order_item (
    price double precision,
    quantity integer,
    product_id bigint NOT NULL,
    order_id bigint NOT NULL
);


--
-- Name: table_product; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.table_product (
    id bigint NOT NULL,
    name character varying(255),
    price double precision
);


--
-- Name: table_product_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.table_product_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: table_product_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.table_product_id_seq OWNED BY public.table_product.id;



ALTER TABLE ONLY public.table_client ALTER COLUMN id SET DEFAULT nextval('public.table_client_id_seq'::regclass);


--
-- Name: table_order id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.table_order ALTER COLUMN id SET DEFAULT nextval('public.table_order_id_seq'::regclass);


--
-- Name: table_product id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.table_product ALTER COLUMN id SET DEFAULT nextval('public.table_product_id_seq'::regclass);


--
-- Name: table_client table_client_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.table_client
    ADD CONSTRAINT table_client_pkey PRIMARY KEY (id);


--
-- Name: table_order_item table_order_item_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.table_order_item
    ADD CONSTRAINT table_order_item_pkey PRIMARY KEY (order_id, product_id);


--
-- Name: table_order table_order_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.table_order
    ADD CONSTRAINT table_order_pkey PRIMARY KEY (id);


--
-- Name: table_product table_product_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.table_product
    ADD CONSTRAINT table_product_pkey PRIMARY KEY (id);


--
-- Name: table_order_item fkcgyoecu95vlv6xu2dfr0t5m73; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.table_order_item
    ADD CONSTRAINT fkcgyoecu95vlv6xu2dfr0t5m73 FOREIGN KEY (product_id) REFERENCES public.table_product(id);


--
-- Name: table_order fkcx64o5o1nv9nxsa397wd1k38i; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.table_order
    ADD CONSTRAINT fkcx64o5o1nv9nxsa397wd1k38i FOREIGN KEY (client_id) REFERENCES public.table_client(id);


--
-- Name: table_order_item fkh57ebtuuet2mghv6bfrtprhof; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.table_order_item
    ADD CONSTRAINT fkh57ebtuuet2mghv6bfrtprhof FOREIGN KEY (order_id) REFERENCES public.table_order(id);

--
-- PostgreSQL database dump complete
--

