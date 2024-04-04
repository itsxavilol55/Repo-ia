import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
df = pd.read_csv('video_games_sales.csv')
df.head()

X = df[['year']]
y = df['global_sales']

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

MPG_Pred = LinearRegression()
MPG_Pred.fit(X_train, y_train)

plt.figure(figsize=(10,10))
plt.scatter(df['year'], df['global_sales'])
plt.scatter(X,MPG_Pred.predict(X), c='Red')
plt.plot(x_values, y_values, c='red', label='y = 324.06565605343344x + 254.35952046202524')
plt.title('Videojuegos')
plt.xlabel('Ventas')
plt.ylabel('Year')
plt.show()