PGDMP                         z            Hospital    14.3    14.3     
           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16394    Hospital    DATABASE     g   CREATE DATABASE "Hospital" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';
    DROP DATABASE "Hospital";
                postgres    false            ?            1259    16396    Admin    TABLE     5  CREATE TABLE public."Admin" (
    id bigint NOT NULL,
    password character varying(64) NOT NULL,
    name character varying(64) NOT NULL,
    surname character varying(64) NOT NULL,
    phone character(12) NOT NULL,
    experience integer NOT NULL,
    address text NOT NULL,
    salary integer NOT NULL
);
    DROP TABLE public."Admin";
       public         heap    postgres    false            ?            1259    16395    Admin_id_seq    SEQUENCE     ?   ALTER TABLE public."Admin" ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Admin_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    210            ?            1259    16404    Doctor    TABLE     ?  CREATE TABLE public."Doctor" (
    id bigint NOT NULL,
    password character varying(64) NOT NULL,
    name character varying(64) NOT NULL,
    surname character varying(64) NOT NULL,
    phone character(12) NOT NULL,
    experience integer NOT NULL,
    address text NOT NULL,
    salary integer NOT NULL,
    diagnoses integer NOT NULL,
    drugs integer NOT NULL,
    injections integer NOT NULL,
    statuses integer NOT NULL
);
    DROP TABLE public."Doctor";
       public         heap    postgres    false            ?            1259    16403    Doctor_id_seq    SEQUENCE     ?   ALTER TABLE public."Doctor" ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Doctor_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    212            ?            1259    16412    Nurse    TABLE     ?  CREATE TABLE public."Nurse" (
    id bigint NOT NULL,
    password character varying(64) NOT NULL,
    name character varying(64) NOT NULL,
    surname character varying(64) NOT NULL,
    phone character(12) NOT NULL,
    experience integer NOT NULL,
    address text NOT NULL,
    salary integer NOT NULL,
    injections integer NOT NULL,
    drugs integer NOT NULL,
    temperatures integer NOT NULL,
    pressures integer NOT NULL
);
    DROP TABLE public."Nurse";
       public         heap    postgres    false            ?            1259    16411    Nurse_id_seq    SEQUENCE     ?   ALTER TABLE public."Nurse" ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Nurse_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    214            ?            1259    16420    Patient    TABLE       CREATE TABLE public."Patient" (
    id bigint NOT NULL,
    name character varying(64) NOT NULL,
    surname character varying(64) NOT NULL,
    phone character(12) NOT NULL,
    address text NOT NULL,
    wardnumber integer NOT NULL,
    drug text NOT NULL,
    injection text NOT NULL,
    diagnosis text NOT NULL,
    drugs integer NOT NULL,
    injections integer NOT NULL,
    status text NOT NULL,
    temperature double precision NOT NULL,
    pressure text NOT NULL,
    idd bigint NOT NULL,
    idn bigint NOT NULL
);
    DROP TABLE public."Patient";
       public         heap    postgres    false            ?            1259    16419    Patient_id_seq    SEQUENCE     ?   ALTER TABLE public."Patient" ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Patient_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    216                      0    16396    Admin 
   TABLE DATA           b   COPY public."Admin" (id, password, name, surname, phone, experience, address, salary) FROM stdin;
    public          postgres    false    210   ?                  0    16404    Doctor 
   TABLE DATA           ?   COPY public."Doctor" (id, password, name, surname, phone, experience, address, salary, diagnoses, drugs, injections, statuses) FROM stdin;
    public          postgres    false    212   H!                 0    16412    Nurse 
   TABLE DATA           ?   COPY public."Nurse" (id, password, name, surname, phone, experience, address, salary, injections, drugs, temperatures, pressures) FROM stdin;
    public          postgres    false    214   ?!                 0    16420    Patient 
   TABLE DATA           ?   COPY public."Patient" (id, name, surname, phone, address, wardnumber, drug, injection, diagnosis, drugs, injections, status, temperature, pressure, idd, idn) FROM stdin;
    public          postgres    false    216   "                  0    0    Admin_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public."Admin_id_seq"', 6, true);
          public          postgres    false    209                       0    0    Doctor_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public."Doctor_id_seq"', 2, true);
          public          postgres    false    211                       0    0    Nurse_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public."Nurse_id_seq"', 3, true);
          public          postgres    false    213                       0    0    Patient_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public."Patient_id_seq"', 6, true);
          public          postgres    false    215            l           2606    16402    Admin Admin_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public."Admin"
    ADD CONSTRAINT "Admin_pkey" PRIMARY KEY (id);
 >   ALTER TABLE ONLY public."Admin" DROP CONSTRAINT "Admin_pkey";
       public            postgres    false    210            n           2606    16410    Doctor Doctor_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public."Doctor"
    ADD CONSTRAINT "Doctor_pkey" PRIMARY KEY (id);
 @   ALTER TABLE ONLY public."Doctor" DROP CONSTRAINT "Doctor_pkey";
       public            postgres    false    212            p           2606    16418    Nurse Nurse_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public."Nurse"
    ADD CONSTRAINT "Nurse_pkey" PRIMARY KEY (id);
 >   ALTER TABLE ONLY public."Nurse" DROP CONSTRAINT "Nurse_pkey";
       public            postgres    false    214            r           2606    16426    Patient Patient_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public."Patient"
    ADD CONSTRAINT "Patient_pkey" PRIMARY KEY (id);
 B   ALTER TABLE ONLY public."Patient" DROP CONSTRAINT "Patient_pkey";
       public            postgres    false    216            s           2606    16427    Patient FK Doctor    FK CONSTRAINT     s   ALTER TABLE ONLY public."Patient"
    ADD CONSTRAINT "FK Doctor" FOREIGN KEY (idd) REFERENCES public."Doctor"(id);
 ?   ALTER TABLE ONLY public."Patient" DROP CONSTRAINT "FK Doctor";
       public          postgres    false    216    3182    212            t           2606    16432    Patient FK Nurse    FK CONSTRAINT     q   ALTER TABLE ONLY public."Patient"
    ADD CONSTRAINT "FK Nurse" FOREIGN KEY (idn) REFERENCES public."Nurse"(id);
 >   ALTER TABLE ONLY public."Patient" DROP CONSTRAINT "FK Nurse";
       public          postgres    false    3184    214    216               ?   x?U???0????)????ZG݋??rA?B?B??~zc?o?q??k?ϡ?'7x?`??p?Ȏ/X4??B$????֎???
?'?????s???lG~???C??5 ???+?_F?LJ???8$!%DY??T?!?]?Ԓq??o?9         S   x?3?L?O.?/??NL?,??H?????|K?3???8????M??M-?M88?K??+?9?M????$F\1z\\\ ?a         \   x?3??+-*N???H?KL/?ጂ1????+S?9???L???,,?8M9?K?|????L?ML9?@??И?А??Hr??qqq wW?         ?   x?e?ˊ1E׷?½??1)?????w??R?N0???Я7:`+wU?:??n???.|h???!??U*{??{d 5????nb?X?yo>9lm??|y?????WbP?-dA??&6?a٦ڥ?d???H?N"??????#V?o?Sr??t?*1???$?????/?x#?V???s?84??A/?w?uY???N_     