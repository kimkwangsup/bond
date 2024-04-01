-- 방명록 게시판
CREATE TABLE gboard(
    gno NUMBER(4)
        CONSTRAINT GBD_NO_PK PRIMARY KEY,
    writer NUMBER(4)
        CONSTRAINT GBD_MNO_FK REFERENCES member(mno)
        CONSTRAINT GBD_MNO_UK UNIQUE
        CONSTRAINT GBD_MNO_NN NOT NULL,
    body VARCHAR2(100 CHAR)
        CONSTRAINT GBD_BODY_NN NOT NULL,
    wdate DATE DEFAULT SYSDATE
        CONSTRAINT GBD_DATE_NN NOT NULL
);
-- 방명록 시퀀스 생성
CREATE SEQUENCE gbrdSeq
    START WITH 1001
    MAXVALUE 9999
    NOCYCLE
    NOCACHE
;




-- 데이터 채우기
INSERT INTO
    gboard( gno, writer, body)
VALUES( 
        gbrdSeq.NEXTVAL, 1000, '들렸다갑니다.'
);

INSERT INTO
    gboard( gno, writer, body)
VALUES( 
        gbrdSeq.NEXTVAL, 1001, '가입인사'
);
INSERT INTO
    gboard( gno, writer, body)
VALUES( 
        gbrdSeq.NEXTVAL, 1044, '아냐입니다.'
);

commit;

SELECT
    gno, name, id, filename sname, body , wdate
FROM
    member, gboard, avatar
WHERE
    mno = writer
    AND avatar = ano
ORDER BY
    wdate desc
;

SELECT
    COUNT(*)
FROM
    member m, gboard g
WHERE
    m.mno = g.writer
    AND id = 'jennie'
;

SELECT
    mno
FROM
    member
WHERE
    id = ?
;