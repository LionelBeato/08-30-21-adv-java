import { initializeApp } from 'firebase/app';
import { getDatabase, ref } from 'firebase/database';

const firebaseConfig = {
    apiKey: "AIzaSyA63zL433e_Fy0F8o_2aDHvvTHsAlQ-F90",
    authDomain: "tts-project-5d0b4.firebaseapp.com",
    databaseURL: "https://tts-project-5d0b4-default-rtdb.firebaseio.com",
    projectId: "tts-project-5d0b4",
    storageBucket: "tts-project-5d0b4.appspot.com",
    messagingSenderId: "357855107385",
    appId: "1:357855107385:web:a0f19ca7a7e7b72be4b0e8",
    measurementId: "G-8M5ZF3V8E3",
};

initializeApp(firebaseConfig);

function getFireBaseRef(refPath) {
    return ref(getDatabase(), refPath);
}

export default {
    getFireBaseRef: getFireBaseRef
};

