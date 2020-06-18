<%@ page language="java" contentType="text/html; charset=utf-8"%>

<html>
<head>
	<title>댓글 게시판</title>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="<%=request.getContextPath() %>/board/script.js"></script>
</head>
<body>

<form action="<%=request.getContextPath() %>/BoardReply.do" method="post">
<input type="hidden" name="board_num" value="${board.board_num}">
<input type="hidden" name="board_re_ref" value="${board.board_re_ref}">
<input type="hidden" name="board_re_lev" value="${board.board_re_lev}">
<input type="hidden" name="board_re_seq" value="${board.board_re_seq}">
<input type="hidden" name="page" value="${page}">

<table cellpadding="0" cellspacing="0" align=center border=1>
	<tr align="center" valign="middle">
		<td colspan="5">댓글 게시판</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">글쓴이</div>
		</td>
		<td>
			<input name="board_name" id="board_name" type="text" size="10" maxlength="10" 
				value=""/>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">비밀번호</div>
		</td>
		<td>
			<input name="board_pass" id="board_pass" type="password" size="10" maxlength="10" 
				value=""/>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">제 목</div>
		</td>
		<td>
			<input name="board_subject" id="board_subject" type="text" size="50" maxlength="100" 
				   value="re."/>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">내 용</div>
		</td>
		<td>
			<textarea name="board_content" id="board_content" cols="67" rows="15"></textarea>
		</td>
	</tr>	
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	<tr align="center" valign="middle">
		<td colspan="5">			
			<input type=submit value="댓글">
			<input type=reset value="취소">
		</td>
	</tr>
</table>
</form>

</body>
</html>