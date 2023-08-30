------------------------------------------------------------
--        Script Postgre 
------------------------------------------------------------



------------------------------------------------------------
-- Table: Users
------------------------------------------------------------
CREATE TABLE public.Users(
	id_users   SERIAL NOT NULL ,
	username   VARCHAR (150) NOT NULL ,
	email      VARCHAR (250) NOT NULL ,
	password   VARCHAR (50) NOT NULL  ,
	CONSTRAINT Users_PK PRIMARY KEY (id_users)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Projects
------------------------------------------------------------
CREATE TABLE public.Projects(
	id_projects    INT  NOT NULL ,
	project_name   VARCHAR (100) NOT NULL ,
	Description    VARCHAR (2000)  NOT NULL ,
	create_date    DATE  NOT NULL  ,
	CONSTRAINT Projects_PK PRIMARY KEY (id_projects)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Lists
------------------------------------------------------------
CREATE TABLE public.Lists(
	list_id     INT  NOT NULL ,
	list_name   VARCHAR (200) NOT NULL  ,
	CONSTRAINT Lists_PK PRIMARY KEY (list_id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Boards
------------------------------------------------------------
CREATE TABLE public.Boards(
	id_boards     INT  NOT NULL ,
	Board_name    VARCHAR (100) NOT NULL ,
	id_projects   INT  NOT NULL ,
	list_id       INT  NOT NULL  ,
	CONSTRAINT Boards_PK PRIMARY KEY (id_boards)

	,CONSTRAINT Boards_Projects_FK FOREIGN KEY (id_projects) REFERENCES public.Projects(id_projects)
	,CONSTRAINT Boards_Lists0_FK FOREIGN KEY (list_id) REFERENCES public.Lists(list_id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: create
------------------------------------------------------------
CREATE TABLE public.create(
	id_projects   INT  NOT NULL ,
	id_users      INT  NOT NULL  ,
	CONSTRAINT create_PK PRIMARY KEY (id_projects,id_users)

	,CONSTRAINT create_Projects_FK FOREIGN KEY (id_projects) REFERENCES public.Projects(id_projects)
	,CONSTRAINT create_Users0_FK FOREIGN KEY (id_users) REFERENCES public.Users(id_users)
)WITHOUT OIDS;



