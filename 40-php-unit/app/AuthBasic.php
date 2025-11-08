<?php
/**
 * Klasa do autoryzacji jednorazowego dostępu do fragmentu serwisu
 * @author rafal zagorowski
 * @since 0.2
 */
class AuthBasic {

    /**
     * Generuje odcisk palca (hash) na podstawie algorytmu
     * @param string $algo Algorytm np. 'sha256'
     * @return string Hash fingerprint
     */
    public function genFingerprint($algo = 'sha256'){
        return hash($algo, $_SERVER['HTTP_USER_AGENT'] ?? 'default-agent');
    }

    /**
     * Generuje kod autoryzacyjny
     * @param int $length Długość kodu (domyślnie 6)
     * @param int $min Minimalna wartość
     * @param int $max Maksymalna wartość
     * @return string Kod numeryczny uzupełniony zerami
     */
    public function createCode($length = 6, $min = 1, $max = 999999){
        $num = rand($min, $max);
        return str_pad($num, $length, '0', STR_PAD_LEFT);
    }

   /**
 * Tworzy token autoryzacyjny dla użytkownika.
 *
 * @param string $email Adres e-mail użytkownika.
 * @param int    $id    Identyfikator użytkownika.
 * @return array<string,string> Tablica z danymi tokenu.
 */
    public function createAuthToken($email, $id){
        $authCode = $this->createCode();
        $authDate = date("Y-m-d");
        $authHour = date("H:i:s");
        $addrIp = '127.0.0.1';
        $opSys = 'Linux';
        $browser = 'FF';

        $cont = array(
            'emlAuth'=>$email,'authCode'=>$authCode,
            'authDate'=>$authDate,'authHour'=>$authHour,
            'addrIp'=>$addrIp,'reqOs'=>$opSys,'reqBrw'=>$browser
        );

        return $cont;
    }

    /**
     * Weryfikuje kod rejestracyjny
     * @param string|int $codeNo
     * @return bool
     */
    public function verifyQuickRegCode($codeNo){
        return (is_numeric($codeNo) && strlen($codeNo) === 6);
    }
}
