--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- Name: opcao; Type: TYPE; Schema: public; Owner: jucapoid
--

CREATE TYPE opcao AS ENUM (
    'Vegetariano',
    'Opção Vegetariano',
    'Prato Principal',
    'Menu Dieta',
    'Opção do Dia'
);


ALTER TYPE opcao OWNER TO jucapoid;

--
-- Name: refeicao; Type: TYPE; Schema: public; Owner: jucapoid
--

CREATE TYPE refeicao AS ENUM (
    'Almoço',
    'Jantar'
);


ALTER TYPE refeicao OWNER TO jucapoid;

--
-- Name: semana; Type: TYPE; Schema: public; Owner: jucapoid
--

CREATE TYPE semana AS ENUM (
    'Segunda-feira',
    'Terça-feira',
    'Quarta-feira',
    'Quinta-feira',
    'Sexta-feira',
    'Sábado'
);


ALTER TYPE semana OWNER TO jucapoid;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: senhas; Type: TABLE; Schema: public; Owner: jucapoid
--

CREATE TABLE senhas (
    senhaid character varying(6) NOT NULL,
    dia semana NOT NULL,
    refeicao refeicao NOT NULL,
    opcao opcao NOT NULL
);


ALTER TABLE senhas OWNER TO jucapoid;

--
-- Name: user_senha; Type: TABLE; Schema: public; Owner: jucapoid
--

CREATE TABLE user_senha (
    username character varying(7) NOT NULL,
    senhaid character varying(6) NOT NULL
);


ALTER TABLE user_senha OWNER TO jucapoid;

--
-- Name: users; Type: TABLE; Schema: public; Owner: jucapoid
--

CREATE TABLE users (
    username character varying(7) NOT NULL,
    password character varying(24) NOT NULL,
    email character varying(24) NOT NULL,
    name character varying(40) NOT NULL,
    credito money DEFAULT 0 NOT NULL
);


ALTER TABLE users OWNER TO jucapoid;

--
-- Data for Name: senhas; Type: TABLE DATA; Schema: public; Owner: jucapoid
--

COPY senhas (senhaid, dia, refeicao, opcao) FROM stdin;
\.


--
-- Data for Name: user_senha; Type: TABLE DATA; Schema: public; Owner: jucapoid
--

COPY user_senha (username, senhaid) FROM stdin;
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: jucapoid
--

COPY users (username, password, email, name, credito) FROM stdin;
\.


--
-- Name: senhas senhas_pkey; Type: CONSTRAINT; Schema: public; Owner: jucapoid
--

ALTER TABLE ONLY senhas
    ADD CONSTRAINT senhas_pkey PRIMARY KEY (senhaid);


--
-- Name: user_senha user_senha_pkey; Type: CONSTRAINT; Schema: public; Owner: jucapoid
--

ALTER TABLE ONLY user_senha
    ADD CONSTRAINT user_senha_pkey PRIMARY KEY (username, senhaid);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: jucapoid
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (username);


--
-- Name: user_senha user_senha_senhaid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: jucapoid
--

ALTER TABLE ONLY user_senha
    ADD CONSTRAINT user_senha_senhaid_fkey FOREIGN KEY (senhaid) REFERENCES senhas(senhaid);


--
-- Name: user_senha user_senha_username_fkey; Type: FK CONSTRAINT; Schema: public; Owner: jucapoid
--

ALTER TABLE ONLY user_senha
    ADD CONSTRAINT user_senha_username_fkey FOREIGN KEY (username) REFERENCES users(username);


--
-- PostgreSQL database dump complete
--

