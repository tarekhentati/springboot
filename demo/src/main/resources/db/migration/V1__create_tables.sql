create table if not exists department
(
    id            integer      not null
        constraint department_pkey
            primary key,
    creation_date timestamp,
    location      varchar(255),
    name          varchar(255) not null,
    updated_date  timestamp
);

create table if not exists employee
(
    id            uuid             not null
        constraint employee_pkey
            primary key,
    age           integer          not null,
    creation_date timestamp,
    first_name    varchar(255)     not null,
    last_name     varchar(255)     not null,
    salary        double precision not null,
    updated_date  timestamp,
    fk_department integer
        constraint fkrpn4jh12p7xkw5dlts2bak8e2
            references department
);