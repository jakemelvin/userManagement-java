PGDMP  /        	            }            userManagement_db    17.2    17.2 	    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            �           1262    24674    userManagement_db    DATABASE     �   CREATE DATABASE "userManagement_db" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
 #   DROP DATABASE "userManagement_db";
                     postgres    false            �            1259    24676    users    TABLE     �   CREATE TABLE public.users (
    id bigint NOT NULL,
    email character varying(255),
    password character varying(255),
    user_name character varying(255)
);
    DROP TABLE public.users;
       public         heap r       postgres    false            �            1259    24675    users_id_seq    SEQUENCE     �   ALTER TABLE public.users ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public               postgres    false    218            �          0    24676    users 
   TABLE DATA           ?   COPY public.users (id, email, password, user_name) FROM stdin;
    public               postgres    false    218   �       �           0    0    users_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.users_id_seq', 3, true);
          public               postgres    false    217            X           2606    24682    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public                 postgres    false    218            �   f   x�3�,�M�)���J�NuH�M���K���T1JT14R	vt�.M����ɷ�/�2I	M�,�21-5�r��-�J�	�+���)q/3-pw��2�
�������� �w�     