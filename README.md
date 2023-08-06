# JavaSwingChatGPT
Java Swing으로 ChatGPT API연결해서 사용하는 프로그램입니다.
<p>
만든 이유. 웹상에서는 프로그래밍 코드입력을 많이 할수가 없어서 만드는 군요. 아직, FileUpload구현은 하지 않았습니다. 아마 스트링 파일로 전송이 될까... 생각하는군요.
</p>

![screen](https://github.com/infott2t/JavaSwingChatGpt/assets/25080178/932613f9-81bf-485d-9d74-84b85c6da442)
![screen02](https://github.com/infott2t/JavaSwingChatGpt/assets/25080178/2c40490b-9fe7-4803-94fd-dc5d048bcb1b)



 
 <p align="center">
  
</p>
 



<h2>또, 요금이 발생하므로 주의해주세요.</h2>

OpenAI API KEY가 필요합니다. 

<a href="https://openai.com">openAI.com</a> 여기에서 회원 가입을 하고 API KEY를 받을 수 있습니다. 

<p>
UI는 FlatLaf 사용했습니다. <a href="https://github.com/JFormDesigner/FlatLaf">https://github.com/JFormDesigner/FlatLaf</a>

<h2>셋팅 방법</h2>
SwingUI.java파일의 32번째줄에 OpenAI API KEY를 적습니다.
122번째 줄에, 모델 셋팅을 바꿀 수 있습니다. 현재는 작은 모델인 gpt-3.5-turbo로 설정해놨습니다.

아직 파일업로드는 구현하지 않았고, timeout버그가 있는 것 같아요.
</p>

 <h2>접속이 빨리 끊기는 이유는 저도 잘 모르지만 이런 설명을 해주네요.</h2>
 <h3>제가 잘못 코드를 짠것일 수도 있구요. 모델을 큰것을 쓰거나... 잘 채팅이 될때도 있고, 안될때도 있는 것 같구요.</h3>
 <h3>아직 저도 원인을 찾고 있습니다.</h3>
 <p>
  "usage": {
    "prompt_tokens": 89,
    "completion_tokens": 319,
    "total_tokens": 408
  }
}




Saved Data start--------------------------------------------------------------------------
0 assidd :

0 user : 안녕하세요.

1 assidd : 안녕하세요! 도와드릴게 있나요?

1 user : 안녕하세요.

2 assidd : 안녕하세요! 토큰은 OpenAI의 GPT 모델에서 텍스트를 처리하는 단위입니다. 토큰의 개수는 모델에 입력된 텍스트의 양과 관련이 있습니다.

- prompt_tokens: prompt_tokens은 요청한 작업의 시작 부분에 사용되는 토큰의 수입니다. GPT-3 모델의 prompt_tokens 최대값은 4096입니다.

- completion_tokens: completion_tokens은 모델의 답변 부분에 사용되는 토큰의 수입니다. 이는 요청의 최대 길이로 제한될 수 있습니다.

- total_tokens: total_tokens은 prompt_tokens과 completion_tokens을 합한 값으로, 요청에 사용된 총 토큰의 수입니다. GPT-3는 4096개의 토큰 이상을 처리할 수 없으므로 total_tokens는 반드시 이 제한 내에 있어야 합니다.

토큰 수는 API 요청 시 제한적으로 사용되며, 총 토큰 수가 많을수록 처리 시간이 오래 걸릴 수 있습니다. 따라서 작업에 필요한 토큰 수를 최적화하는 것이 중요합니다.

2 user : 토큰에 대해 알고 싶습니다. usage항복에 prompt_tokens, completion_tokens, total_tokens에 대해 알려주세요.

Saved Data end -----------------------------------------------------------------------
</p>
<br/><br/><br/>
기부는 하실 분은 여기에 해주세요. <br/>
<a href="https://paypal.me/jcoop45">Paypal 기부</a><br/>  <a href="https://toss.me/jcoop">토스 기부</a>
<br/><br/>

<h2>좋은 하루되세요. 감사합니다.</h2>
