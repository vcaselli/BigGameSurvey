import React, { useEffect, useState } from 'react';
import './styles.css';
import axios from 'axios';
import { RecordsReponse } from './types';
import { formatDate } from './helpers';
import Pagination from './pagination';
import Filters from '../../components/filters';


const BASE_URL = "https://caselli-gse.herokuapp.com/";

const Records = () => {

    const [recordsResponse, setRecordsResponse] = useState<RecordsReponse>();
    console.log(recordsResponse);

    const  [activePage, setActivePage] = useState(0);

    useEffect(() => {
        axios.get(`${BASE_URL}/records?linesPerPage=12&page=${activePage}`)
            .then(response => setRecordsResponse(response.data))
    },[activePage]);

    const handlePageChange = (index: number) => {
        setActivePage(index)
    }

    

    return (
        <div className="page-container">
            <Filters link="/charts" linkText="VER GRÁFICO" />
            <table className="records-table" cellPadding="0" cellSpacing="0">
                <thead>
                    <tr>
                        <th>INSTANTE</th>
                        <th>NOME</th>
                        <th>IDADE</th>
                        <th>PLATAFORMA</th>
                        <th>GÊNERO</th>
                        <th>TÍTULO DO GAME</th>
                    </tr>
                </thead>
                <tbody>
                    {recordsResponse?.content.map(record => (
                        <tr key={record.id}>
                            <td>{formatDate(record.moment)}</td>
                            <td>{record.name}</td>
                            <td>{record.age}</td>
                            <td className="text-secondary">{record.gamePlatform}</td>
                            <td>{record.gameGenre}</td>
                            <td className="text-primary">{record.gameTitle}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <Pagination 
            activePage={activePage}
            totalPages={recordsResponse?.totalPages}
            goToPage={handlePageChange}
            />
        </div>
    );

}



export default Records;