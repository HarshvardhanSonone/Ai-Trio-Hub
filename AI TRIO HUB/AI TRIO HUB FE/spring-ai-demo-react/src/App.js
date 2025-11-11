import React, { useState } from 'react';
import './App.css';
import ImageGenerator from './components/ImageGenerator';
import ChatComponent from './components/ChatComponent';
import MovieRecommendation from './components/movieRecomendation';

function App() {
  const [activeTab, setActiveTab] = useState('image-generator');

  const handleTabChange = (tab) => {
    //alert(tab)
    setActiveTab(tab);
  };

  return (
    <div className="App">
      <button className={activeTab === 'image-generator' ? 'active' : ''}
       onClick={() => handleTabChange('image-generator')}>
        Image Generator
        </button>
      <button  className={activeTab === 'chat' ? 'active' : ''}
      onClick={() => handleTabChange('chat')}>
        Ask AI
        </button>
      <button className={activeTab === 'movie-recommendation' ? 'active' : ''}
      onClick={() => handleTabChange('movie-recommendation')}>
        Movie Recommendation
        </button>

        <div>
          {activeTab === 'image-generator' && <ImageGenerator/>}
          {activeTab === 'chat' && <ChatComponent/>}
          {activeTab === 'movie-recommendation' && <MovieRecommendation/>}
        </div>
    </div>
  );
}

export default App;
