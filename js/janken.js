// janken.js

/**
 * (参考) ajaxでPOST
 * 【JavaScript入門】FormやAjaxのPOST送信・取得の方法まとめ！
 *  https://www.sejuku.net/blog/53627
 */

( () => {
  const send_post = ( (val) => {
    const form = document.createElement( 'form' );
    const request = document.createElement( 'input' );

    form.method = 'post';
    form.action = '/janken/Jadge';

    request.type = 'hidden';
    request.name = 'userHand';
    request.value = val;

    form.appendChild( request );
    document.body.appendChild( form );

    form.submit();
  });
  
  // クリックしたオブジェクトを ele で取得
  const modifyBack = ( (ele) => {
    console.log(ele);
    ele.target.style.border = "solid 2px #666";
    const select = ele.target.getAttribute('alt');

    send_post( select );
    
    // ajaxでPOST
    /* const xhr = new XMLHttpRequest();
     * xhr.open('POST', '/janken/Jadge');
     * xhr.setRequestHeader('content-type', 'application/x-www-form-urlencoded;charset=UTF-8');
     * xhr.send( 'userHand=' + select );

     * */
  });

  const gu_pic = document.getElementById("gu-pic");
  console.log(gu_pic);
  const choki_pic = document.getElementById("choki-pic");
  console.log(choki_pic);
  const pa_pic = document.getElementById("pa-pic");
  console.log(pa_pic);
  gu_pic.addEventListener("click", modifyBack, false);
  choki_pic.addEventListener("click", modifyBack, false);
  pa_pic.addEventListener("click", modifyBack, false);

})();

// 修正時刻: Mon Aug 17 18:46:43 2020
