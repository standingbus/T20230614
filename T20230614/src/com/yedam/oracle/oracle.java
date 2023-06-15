//create table tbl_board(
//    brd_no number primary key,
//
//	brd_title varchar(100) not null,
//
//	brd_writer varchar(10) not null,
//
//	brd_content varchar(100),
//
//	create_date date default sysdate,
//
//	click_cnt number default 0
//    );
//    create sequence board_seq;		
//	insert into tbl_board (brd_no, brd_title, brd_content, brd_writer)
//			values (board_seq.nextval, 'title test', 'content test', 'user1');
//    
//    select * from tbl_board;
//    
//    