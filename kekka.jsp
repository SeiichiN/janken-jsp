<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="user" value="user"></c:set>
<c:set var="com" value="com"></c:set>
<c:set var="draw" value="draw"></c:set>

<% String winner = (String)request.getAttribute("winner"); %>
<% System.out.println("index.jsp:" + winner ); %>
<!doctype html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <title>じゃんけんゲーム</title>
    <link rel="stylesheet" href="css/janken.css"/>
  </head>
  <body>
    <h1>じゃんけんゲーム結果</h1>
    <section class="kekka-area">
      <p class="kekka">あなた:<br/>
        <img src="images/${janken.user}.png" alt="gu" class="pic" />
      </p>
      <p class="kekka">わたし:<br/>
        <img src="images/${janken.com}.png" alt="gu" class="pic" />
      </p>
      <p class="kekka-word">
        <c:set var="_winner" value="${winner}" />
        <!-- <c:out value="${_winner}" /> -->
        <c:choose>
          <c:when test="${_winner == user}">
            あなたの勝ちです
          </c:when>
          <c:when test="${_winner == com}">
            わたしの勝ちです
          </c:when>
          <c:when test="${_winner == draw}">
            引き分けです
          </c:when>
        </c:choose>
      </p>
    </section>
    <section class="replay-area">
      <a href="index.jsp">もう一度する</a>
    </section>
  </body>
</html>



<!-- 修正時刻: Mon Aug 17 18:11:27 2020 -->
