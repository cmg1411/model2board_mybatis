package dao;

import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import model.BoardBean;

public class BoardDAO {

	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	// SqlSession 객체 생성
	private SqlSession getSession() {
		SqlSession session = null;
		Reader reader = null;
		
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
			session = sf.openSession(true); // true속성은 auto commit
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return session;
	}
	
	
	public int insert(BoardBean board) throws Exception{
		int result = 0;
		SqlSession session = null;
		
		session = getSession();
		result = session.insert("board_insert", board);
		
		return result;
	}
	
	// 총 데이터 갯수 구하기
	public int getCount() throws Exception{
		int result = 0;
		SqlSession session = null;
		
		session = getSession();
		result = session.selectOne("allBoard");
		
		return result;
	}
	
	// 글목록
	//public List<BoardBean> getList(int start, int end){
	public List<BoardBean> getList(int page) throws Exception{
		List<BoardBean> list = new ArrayList<BoardBean>();
		SqlSession session = null;
		
		session = getSession();
		list = session.selectList("board_list", page);
		
		return list;
	}
		
		
	// 조회수 증가
	public void readcountUpdate(int board_num) throws Exception{
		SqlSession session = null;
		
		session = getSession();
		session.update("board_updatecount", board_num);
	}
		
		
	// 상세 페이지 
	public BoardBean getDetail(int board_num) throws Exception{
		BoardBean board = new BoardBean();

		SqlSession session = getSession();
		board = (BoardBean) session.selectOne("selectDetail", board_num);
		return board;
	}
		
		//댓글출력순서(board_re_seq값 1증가)
	public void updateSeq(BoardBean board) throws Exception {
		SqlSession session = getSession();
			
		session.update("board_updateSeq", board);
	}
		
		
		// 댓글 작성
		public int boardReply(BoardBean board) throws Exception{
			int result = 0;
			SqlSession session = getSession();
			
			result = session.insert("board_reply", board);
			
			return result;
		}
		

		// 글수정
		public int update(BoardBean board) throws Exception{
			int result = 0;
			SqlSession session = getSession();
			
			result = session.insert("board_update", board);
			return result;
		}
		
		// 글 삭제
		public int delete(int board_num) throws Exception{
			int result = 0;
			SqlSession session = getSession();
			
			result = session.insert("board_delete", board_num);
			return result;
		}
}
