alter table MAT_LOCATION add foreign key(mat_id) references MATERIAL(id);
alter table MAT_PRICE add foreign key(mat_id) references MATERIAL(id);
alter table MAT_ALT_NAMES add foreign key(mat_id) references MATERIAL(id);
