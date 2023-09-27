create database basedados;
use basedados;

create table vaga(
	id_vaga bigint(10) not null auto_increment,
	numero int not null, 	
primary key(id_vaga)
)engine=InnoDB;

create table veiculo(
	id bigint(10) not null auto_increment,
	marca varchar(255) not null, 
	modelo varchar(255) not null,
	ano varchar(255) not null, 
	placa varchar(10),
	cor varchar(20),
	id_proprietario bigint(10) not null unique, 
	id_vaga bigint(10) not null, 
	foreign key (id_vaga) references vaga(id_vaga), 
	primary key(id)
)engine=InnoDB;