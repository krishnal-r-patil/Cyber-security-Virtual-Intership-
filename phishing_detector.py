from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.naive_bayes import MultinomialNB
from sklearn.pipeline import Pipeline
from sklearn.metrics import accuracy_score, confusion_matrix

emails=[
("Congratulations! You've won a free iPhone. Click http://fake.com to claim.","phishing"),
("Your bank account is suspended. Verify immediately.","phishing"),
("Meeting at 3 PM tomorrow in the conference room.","safe"),
("Your Amazon order has been shipped.","safe"),
("Reset your password using this secure link.","safe"),
("Urgent! Login now to avoid account closure.","phishing")
]
X=[e[0] for e in emails]
y=[e[1] for e in emails]
model=Pipeline([('tfidf',TfidfVectorizer()),('clf',MultinomialNB())])
model.fit(X,y)
pred=model.predict(X)
print('Accuracy:',accuracy_score(y,pred))
print('Confusion Matrix:')
print(confusion_matrix(y,pred,labels=['phishing','safe']))
while True:
    t=input("Enter email text (or exit): ")
    if t.lower()=='exit': break
    print('Prediction:',model.predict([t])[0])
